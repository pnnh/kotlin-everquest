import QuestTable.create_time
import QuestTable.description
import QuestTable.executor
import QuestTable.organization
import QuestTable.parent
import QuestTable.pk
import QuestTable.priority
import QuestTable.project
import QuestTable.status
import QuestTable.tags
import QuestTable.title
import QuestTable.update_time
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.jodatime.datetime
import org.jetbrains.exposed.sql.transactions.transaction
import org.joda.time.DateTime
import xyz.sfx.models.*

val dbNameLength = 64

object QuestTable : Table("quests") {
    val pk = varchar("pk", dbNameLength)
    val priority = integer("priority")
    val title = varchar("title", length = dbNameLength)
    val executor = varchar("executor", dbNameLength)
    val creator = varchar("creator", dbNameLength)
    val project = varchar("project", dbNameLength)
    val tags = varchar("tags", 128)
    val parent = varchar("parent", dbNameLength)
    val create_time = datetime("create_time")
    val update_time = datetime("update_time")
    val status = integer("status")
    val organization = varchar("organization", dbNameLength)
    val description = varchar("description", 256)

    override val primaryKey = PrimaryKey(pk, name = "quests_pk")
}

fun newQuest(aPk: String, aTitle: String) {

    transaction {
        QuestTable.insert {
            it[pk] = aPk
            it[priority] = 0
            it[title] = aTitle
            it[executor] = ""
            it[creator] = "1"   // 测试目的
            it[project] = ""
            it[tags] = ""
            it[parent] = ""
            it[create_time] = DateTime.now()
            it[update_time] = DateTime.now()
            it[status] = 0
            it[organization] = ""
            it[description] = ""
        }
    }

}

fun queryQuest(creator: String): ArrayList<Quest> {
    val list = ArrayList<Quest>()
    transaction {
        val resultSet = QuestTable.select {
            QuestTable.creator eq creator
        }.orderBy(update_time, SortOrder.DESC).limit(100)
        resultSet.mapTo(list) { record ->
            Quest(
                pk = record[pk],
                priority = record[priority],
                title = record[title],
                executor = record[executor],
                creator = record[executor],
                project = record[project],
                tags = record[tags],
                parent = record[parent],
//                create_time = record[create_time],
//                update_time = record[update_time],
                status = record[status],
                organization = record[organization],
                description = record[description],
            )
        }
    }
    return list
}