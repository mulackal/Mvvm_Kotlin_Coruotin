package com.vip.mvvm_setup.utils.coroutin

import kotlinx.coroutines.*

// LAZY :- if we use lazy then it only work when ever is need..
// if already data then it give other wise fetch the data
fun<T> lazyDeferred(block: suspend CoroutineScope.() -> T): Lazy<Deferred<T>>{
    return lazy {
        GlobalScope.async(start = CoroutineStart.LAZY) {
            block.invoke(this)
        }
    }
}