package com.example.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class ToDoViewModel : ViewModel() {
    val text = mutableStateOf("")

    val todoList = mutableStateListOf<ToDoData>()

    val onSubmit: (String) -> Unit = {
        val key = (todoList.lastOrNull()?.key ?: 0) + 1
        todoList.add(ToDoData(key, text.value, false))
        text.value = ""
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
}