package com.project.ulul.ui.state

sealed class UIState<T> {
    class Idle<T> : UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val error: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
} //Для того чтобы отслеживать в каком состоянии находится фрагмент
