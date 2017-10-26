import { Component, OnInit } from '@angular/core';
import { Http,Response,Headers } from '@angular/http';
import { RouterModule,Router,ActivatedRoute } from '@angular/router';

import 'rxjs/add/operator/map';

@Component({
  selector: 'app-edituser',
  templateUrl: './edituser.component.html',
  styleUrls: ['./edituser.component.css']
})
export class EdituserComponent implements OnInit {

  isUpdate:boolean=false;
  id:number;
  data=[];
  users=[];
  userObj:any;
  private header = new Headers({'Content-Type': 'application/json'});

  constructor(private router:Router,private route:ActivatedRoute,private http:Http ) { }
  edituser(user){
    this.userObj = {
      "fullname": user.fullname,
      "date":user.date,
      "sex":user.sex
    }
    const url =`${"http://59f04fd8ce72350012bebfa2.mockapi.io/user"}/${this.id}`;
    this.http.put(url, JSON.stringify(this.userObj), {headers:this.header}).toPromise()
    .then(()=>{
      this.router.navigate(['/']);//go to Home
    });
  }
  ngOnInit() {
    this.route.params.subscribe(
      params =>{
        this.id = +params['id'];
      }
    )
    this.http.get("http://59f04fd8ce72350012bebfa2.mockapi.io/user").subscribe(
      (res:Response)=>{
        this.users=res.json();
        for(var i=0;i<this.users.length;i++){
          if(parseInt(this.users[i].id)==this.id){
            this.isUpdate = true;
            this.data = this.users[i];
            console.log(this.data);
            break;
          }
          else{
            this.isUpdate = false;
          }
        }
      }
    )
  }

}
