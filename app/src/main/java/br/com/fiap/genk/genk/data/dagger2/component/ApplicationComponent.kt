package br.com.fiap.genk.genk.data.dagger2.component

import android.app.Application
import br.com.fiap.genk.genk.data.dagger2.modules.AndroidModule
import br.com.fiap.genk.genk.presentation.ui.activity.BaseActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AndroidModule::class])
interface ApplicationComponent {

    fun inject(application: Application)

    fun inject(baseActivity: BaseActivity)

}

