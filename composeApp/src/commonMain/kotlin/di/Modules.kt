package di

import MyViewModel
import dependancies.MyRepository
import dependancies.MyRepositoryImpl
import org.koin.compose.viewmodel.dsl.viewModelOf
import org.koin.core.module.Module
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
/*
Think of koin not like a di, but a service locator.
Shared can be used across platformed.
Koin gts dependencies at run time rather than at compile time

 */
val sharedModule = module {
    // single here means
    //everytime we call this, we get a new instance of MyRepositoryImpl

//    single { MyRepositoryImpl(get()) }.bind<MyRepository>()

    // can also do a short hand version
    singleOf(::MyRepositoryImpl).bind<MyRepository>()
    viewModelOf(::MyViewModel)
}

expect val platformModule: Module