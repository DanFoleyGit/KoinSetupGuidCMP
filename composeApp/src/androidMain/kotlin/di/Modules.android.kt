package di

import MyViewModel
import dependancies.DbClient
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

/*
    DbClient in this case needs context which needs to supplied differently than web and iOS
    Same with viewmodels as they are bound to the life cycle of the current screen with a viewmodel factory

 */
actual val platformModule = module {
    singleOf(::DbClient)
//    viewModelOf(:: MyViewModel)
}
