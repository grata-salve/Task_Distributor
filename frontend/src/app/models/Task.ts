import {Team} from "./Team";

export interface Task {
  id: number;
  team: Team;
  taskName: string;
  description: string;
  creationDate: Date;
  status: string;
}
