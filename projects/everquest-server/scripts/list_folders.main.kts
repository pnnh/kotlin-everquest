import java.io.File

val path = if (args.contains("-d")) args[1 + args.indexOf("-d")]
    else "."

val folders = File(path).listFiles() { file -> file.isDirectory() }
folders?.forEach { folder -> println(folder) }

// 执行方式
// kotlinc -script list_folders.main.kts -- -d ..