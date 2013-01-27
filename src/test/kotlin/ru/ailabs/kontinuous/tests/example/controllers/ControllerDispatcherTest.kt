/**
 * Created with IntelliJ IDEA.
 * User: andrew
 * Date: 27.01.13
 * Time: 13:04
 * To change this template use File | Settings | File Templates.
 */

package ru.ailabs.kontinuous.tests

import ru.ailabs.kontinuous.getHelloString
import kotlin.test.assertEquals
import junit.framework.TestCase
import ru.ailabs.kontinuous.annotation.path
import ru.ailabs.kontinuous.annotation.routes
import ru.ailabs.kontinuous.dispatcher.ControllerDispatcher
import org.junit.Test
import ru.ailabs.kontinuous.controller.Action


object Controller {
    val index =  Action ({
        Pair(hashMapOf("name" to "Hello Index"), "indexView")
    })

    val post = Action ({
        Pair(hashMapOf("name" to "Hello from post"), "postView")
    })
}

routes class Routes {

    path("/")  val index = Controller.index
    path("/post")  val post = Controller.post
}

class ControllerDispatcherTest {

    val dispatcher = ControllerDispatcher();

    Test fun rightPath() : Unit {
        assertEquals("Hello Index", dispatcher.dispatch("/"))
        assertEquals("Hello from post", dispatcher.dispatch("/post"))
    }

    Test fun invalidPath() : Unit {
        assertEquals("No route found", dispatcher.dispatch("/asd"))
    }
}