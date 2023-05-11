import {User} from "./User";
import {Team} from "./Team";
import {Role} from "./Role";

export interface UserTeam {
  user: User,
  team: Team,
  role: Role
}
