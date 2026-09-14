import { Component, OnInit } from '@angular/core';
import { UserApiService } from '../user-api.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  users: any[] = [];
  newUser: any = {};
  selectedUserId: string | null = null;
  selectedUser: any = {};

  constructor(private apiService: UserApiService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.apiService.getUsers().subscribe((data: any) => {
      this.users = data;
    });
  }

  createUser(): void {
    this.apiService.createUser(this.newUser).subscribe(() => {
      this.getUsers();
      this.newUser = {};
    });
  }

  updateUser(): void {
    if (this.selectedUserId) {
      this.apiService.updateUser(this.selectedUserId, this.selectedUser).subscribe(() => {
        this.getUsers();
        this.selectedUserId = null;
        this.selectedUser = {};
      });
    }
  }

  deleteUser(id: string): void {
    this.apiService.deleteUser(id).subscribe(() => {
      this.getUsers();
    });
  }

  onSelectUser(user: any): void {
    this.selectedUserId = user.id;
    this.selectedUser = { ...user };
  }
}
