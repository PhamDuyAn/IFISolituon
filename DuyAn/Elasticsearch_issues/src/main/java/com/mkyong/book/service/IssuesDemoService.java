package com.mkyong.book.service;

import com.mkyong.book.model.IssuesDemo;


public interface IssuesDemoService {
	IssuesDemo findByIssuesDemoId(int id);

	void saveIssuesDemo(IssuesDemo issue);

	void updateIssuesDemo(IssuesDemo issue);

	void deleteIssuesDemoById(int id);

	void deleteAllProjects();

	Iterable<IssuesDemo> findAllIssuesDemo();

	boolean isIssuesDemoExist(IssuesDemo issues);

}
