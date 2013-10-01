package models

import java.util.Date

import anorm._
import anorm.SqlParser._

import play.api.db._
import play.api.Play.current

case class Task(
  id: Long,
  name: String,
  created_on: Date
)

object Task {
  val task = {
    get[Long]("id") ~
    get[String]("name") ~
    get[Date]("created_on") map {
      case id~name~created_on => Task(id, name, created_on)
    }
  }

  def all(): List[Task] = DB.withConnection { implicit c =>
    SQL("select * from tasks").as(task *)
  }

  def create(name: String) = DB.withConnection { implicit c =>
    SQL("insert into tasks (name) values ({name})").on(
      'name -> name
    ).executeUpdate()
  }

  def delete(id: Long) = DB.withConnection { implicit c =>
    SQL("delete from tasks where id = {id}").on(
      'id -> id
    ).executeUpdate()
  }
}
