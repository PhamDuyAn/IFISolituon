package com.mkyong;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

//import com.google.gson.Gson;
import com.mkyong.book.model.IssuesDemo;
import com.mkyong.book.service.IssuesDemoService;
import com.taskadapter.redmineapi.IssueManager;
import com.taskadapter.redmineapi.RedmineException;
import com.taskadapter.redmineapi.RedmineManager;
import com.taskadapter.redmineapi.RedmineManagerFactory;
import com.taskadapter.redmineapi.bean.Issue;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ElasticsearchOperations es;

	@Autowired
	IssuesDemoService issuesDemoService;


	public static void main(String args[]) throws RedmineException {
		SpringApplication.run(Application.class, args);

	}

	public void addIssues() throws RedmineException, IOException {
		System.setProperty("http.proxyHost", "10.225.3.1");
		System.setProperty("http.proxyPort", "3128");
		String uri = "http://apis.ifisolution.local:8080/projects/training-project";
		String projectKey = "training-project";
		Integer queryId = null; // any
		IssuesDemo issuedemo = new IssuesDemo();
		RedmineManager mgr = RedmineManagerFactory.createWithUserAuth(uri, "fresher12", "12345678");
		
		
		IssueManager issueManager = mgr.getIssueManager();
		List<Issue> issues = issueManager.getIssues(projectKey, queryId);
		for (Issue issue : issues) {
			issuedemo.setId(issue.getId());
			issuedemo.setAssignee(issue.getAssignee().getFullName());
			issuedemo.setAuthor(issue.getAuthor().getFullName());
			issuedemo.setStatusId(issue.getStatusId());
			issuedemo.setTracker(issue.getTracker().getName());
			issuedemo.setCreatedOn(issue.getCreatedOn());
			issuedemo.setUpdatedOn(issue.getUpdatedOn());
			// issuedemo.setCategory(issue.getCategory().getName());
			issuedemo.setSubject(issue.getSubject());
			issuedemo.setPriorityText(issue.getPriorityText());
			// issuedemo.setAssignee(issue.getAssignee());
			System.out.println(issuedemo.toString());
			issuesDemoService.saveIssuesDemo(issuedemo);
		}
	}

	@Override
	public void run(String... args) throws Exception {

		printElasticSearchInfo();

		addIssues();

	}

	// useful for debug
	private void printElasticSearchInfo() {

		System.out.println("--ElasticSearch-->");
		Client client = es.getClient();
		Map<String, String> asMap = client.settings().getAsMap();

		asMap.forEach((k, v) -> {
			System.out.println(k + " = " + v);
		});
		System.out.println("<--ElasticSearch--");
	}

}