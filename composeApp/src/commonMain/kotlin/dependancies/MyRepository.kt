package dependancies

interface MyRepository {
    fun getHelloWorldString() : String
}

class MyRepositoryImpl(
    private val dbClient: DbClient
): MyRepository {
    override fun getHelloWorldString(): String {
        return "Hello World"
    }
}