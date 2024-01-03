package com.example.todoapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todoapp.ui.theme.TodoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopLevel()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TopLevel() {
    val (text, setText) = remember {
        mutableStateOf("")
    }
    val todoList = remember {
        mutableStateListOf<ToDoData>()
    }
    val onSubmit: (String) -> Unit = {
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(ToDoData(key, text, false))
        setText("")
    }

    val onToggle: (Int, Boolean) -> Unit = { key, checked ->
        val index = todoList.indexOfFirst { it.key == key }
        todoList[index] = todoList[index].copy(done = checked)
    }

    val onDelete: (Int) -> Unit = { key ->
        todoList.remove(todoList.first { it.key == key })
    }

    val onEdit: (Int, String) -> Unit = { key, text ->
        val index = todoList.indexOfFirst { it.key == key }
        todoList[index] = todoList[index].copy(text = text)
    }

    Scaffold {
        Column {
            ToDoInput(text = text, onTextChange = setText, onSubmit = onSubmit)
            LazyColumn {
                items(todoList, key = { it.key }) { todoData ->
                    ToDo(
                        toDoData = todoData,
                        onToggle = onToggle,
                        onDelete = onDelete,
                        onEdit = onEdit
                    )
                }
            }
        }
    }
}

@Composable
fun ToDo(
    toDoData: ToDoData,
    onEdit: (key: Int, text: String) -> Unit = { _, _ -> },
    onToggle: (key: Int, checked: Boolean) -> Unit = { _, _ -> },
    onDelete: (key: Int) -> Unit = {}
) {
    var isEditing by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier.padding(4.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {

        Crossfade(targetState = isEditing, label = "편집 여부 애니메이션") {

            when (it) {
                true -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        var newText by remember {
                            mutableStateOf(toDoData.text)
                        }

                        OutlinedTextField(
                            value = newText,
                            onValueChange = { text -> newText = text },
                            modifier = Modifier.weight(1f)
                        )
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = {
                            onEdit(toDoData.key, newText)
                            isEditing = false
                        }) {
                            Text(text = "완료")
                        }
                    }
                }

                false -> {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text(text = toDoData.text, modifier = Modifier.weight(1f))
                        Text(text = "완료")
                        Checkbox(
                            checked = toDoData.done,
                            onCheckedChange = { checked -> onToggle(toDoData.key, checked) })
                        Button(onClick = { isEditing = true }) {
                            Text(text = "수정")
                        }
                        Spacer(modifier = Modifier.size(4.dp))
                        Button(onClick = { onDelete(toDoData.key) }) {
                            Text(text = "삭제")
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun ToDoInput(
    text: String,
    onTextChange: (String) -> Unit,
    onSubmit: (String) -> Unit
) {
    Row(modifier = Modifier.padding(8.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(modifier = Modifier.size(8.dp))
        Button(onClick = { onSubmit(text) }) {
            Text(text = "입력")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TodoAppTheme {
        TopLevel()
    }
}

@Preview(showBackground = true)
@Composable
fun ToDo() {
    TodoAppTheme {
        ToDo(toDoData = ToDoData(1, "nice", false))
    }
}

data class ToDoData(
    val key: Int,
    val text: String,
    val done: Boolean = false
)