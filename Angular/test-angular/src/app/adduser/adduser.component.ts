import { Component, OnInit } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';

import { UserComponent } from '../user/user.component';
import { DataService } from '../services/data.service';


@Component({
  selector: 'app-adduser',
  templateUrl: './adduser.component.html',
  styleUrls: ['./adduser.component.css']
})
export class AdduserComponent implements OnInit {
  // user1:User1[];
  constructor(private http:Http) { }
  isAdded:boolean=false;
  userObj: any;
  adduser = function(user1){
    this.userObj = {
      "fullname":user1.fullname,
      "date":user1.date,
      "sex":user1.sex
    }
    this.http.post('http://59f04fd8ce72350012bebfa2.mockapi.io/user',this.userObj).subscribe((res:Response)=>{
    this.isAdded=true;
    });
  }
  // userObj: any;
    // this.userObj = {

    //   "fullname":user1.fullname,
    //   "date":user1.date,
    //   "sex":user1.sex
    // }
  // constructor(private dataService:DataService){
  //  this.dataService.adduser()
  // }
  ngOnInit() {
  }
}

