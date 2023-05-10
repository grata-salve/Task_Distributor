import { Task } from "./Task";
import { User } from "./User";

export interface UserTasks {
  id: number;
  user: User;
  task: Task;
  assignDate: Date;
}
