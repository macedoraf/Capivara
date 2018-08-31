package br.com.fiap.genk.genk.presentation.ui.activity

import android.location.LocationManager
import android.os.Bundle
import android.os.PersistableBundle
import br.com.fiap.genk.genk.data.dagger2.modules.Repositorio
import br.com.fiap.genk.genk.presentation.ui.MyApplication
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var locationManager: LocationManager

    lateinit var string: String

    @Inject
    lateinit var repositorio: Repositorio

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        MyApplication.graph.inject(this)


    }


}