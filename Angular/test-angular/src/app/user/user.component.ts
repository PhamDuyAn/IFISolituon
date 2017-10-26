import { Component, OnInit } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';

import { DataService } from '../services/data.service';
import 'rxjs/add/operator/toPromise';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  id:number;
  private header = new Headers({'Content-Type': 'application/json'});

  users:User[];
  // constructor(private dataService:DataService) { 
  //   console.log('contructor run...');
  //   this.dataService.getUser().subscribe((users) =>{
  //     console.log(users);
  //     this.users=users;
  //   });
  // }
  
   constructor(private http:Http) { }

  getData= function(){
    this.http.get("http://59f04fd8ce72350012bebfa2.mockapi.io/user").subscribe(
      (res:Response)=>{
        this.users=res.json();
      }
    )
  }

  deleteuser = function(id){
    
    if(confirm('Are you sure???')){
      const url =`${"http://59f04fd8ce72350012bebfa2.mockapi.io/user"}/${id}`;
      return this.http.delete(url,{header:this.header}).toPromise()
      .then(()=>{
        this.getData();
      })
    }
  }
  ngOnInit() {
    this.getData();
  }
  
  

}
interface Address{
  street:string,
  city:string,
  state:string
}
interface User{
  id:number,
  fullname:string,
  date:Date,
  address:Address,
  sex:string,
}
