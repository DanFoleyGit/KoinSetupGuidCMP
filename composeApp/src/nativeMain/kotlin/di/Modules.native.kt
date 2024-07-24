package di

import MyViewModel
import dependancies.DbClient
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
We do the same as native for iOS, where Koin knows how to instantiate the dependancy and the ViewModel
VM doesnt need to bind to the lifeCycle so we just create an instance
In theory we can use this in the shared the code as Koin allows viewModelOf for iOS which it didnt use to.
 */
actual val platformModule = module {
    singleOf(::DbClient)
//    viewModelOf(::MyViewModel)
}