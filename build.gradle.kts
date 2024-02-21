plugins {
    //trick: for the same plugin versions in all sub-modules
    val sqlDelightVersion = "2.0.0"
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    id("app.cash.sqldelight").version(sqlDelightVersion).apply(false)

}
