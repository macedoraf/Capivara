package br.com.fiap.genk.genk.data.dagger2.modules

import android.app.Application
import android.content.Context
import android.location.LocationManager
import br.com.fiap.genk.genk.data.dagger2.ForApplication
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AndroidModule(private val application: Application) {


    @Provides
    @Singleton
    @ForApplication
    fun provideApplicationContext(): Context = application

    fun provideLocationManager(): LocationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager

    fun provideIRepositorio(): Repositorio {
        return object : Repositorio {
            override fun metodo() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        }
    }

    @Provides
    @Singleton
    @Named("something")
    fun provideSomething(): String = "Something"


}

interface Repositorio {

    fun metodo()


}
