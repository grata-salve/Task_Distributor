export class Team {
  id: number;
  teamName: string;
  description: string;

  constructor(
    id: number,
    teamName: string,
    description: string
  ) {
    this.id = id;
    this.teamName = teamName;
    this.description = description;
  }
}
