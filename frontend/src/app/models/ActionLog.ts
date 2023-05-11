import {Task} from "./Task";
import {User} from "./User";
import {Action} from "./Action";

export interface ActionLog {
  id: number;
  task: Task;
  user: User;
  action: Action;
  actionDateTime: Date;
}
