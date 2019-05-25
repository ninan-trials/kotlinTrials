package leo.orion.domain.interfaces

public interface Command<out T> {
    fun execute() : T
}
