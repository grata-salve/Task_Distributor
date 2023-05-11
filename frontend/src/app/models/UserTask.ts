import { Task } from "./Task";
import { User } from "./User";

export interface UserTask {
  id: number;
  user: User;
  task: Task;
  assignDate: Date;
}
