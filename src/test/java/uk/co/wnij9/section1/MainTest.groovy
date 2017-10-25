package uk.co.wnij9.section1

import org.slf4j.Logger
import spock.lang.Specification

class MainTest extends Specification {

    def 'test the printed output'(){

        given: 'I have an expected output and a main class with a mocked logger'
          def expectedOutput = "Welcome to Java 9!"
          def helloWorld = new Main()
          def logger = Mock(Logger)
        and:
          helloWorld.logger = logger

        when: 'I invoke the main message'
          helloWorld.main()

        then: 'I expect 1 invocation of the logger with the expected message output'
          1 * helloWorld.logger.info(expectedOutput)
    }
}
