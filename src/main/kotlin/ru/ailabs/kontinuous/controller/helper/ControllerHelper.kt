package ru.ailabs.kontinuous.controller.helper

import ru.ailabs.kontinuous.view.ViewResolver
import com.fasterxml.jackson.databind.ObjectMapper

/**
 * Alien Invaders Ltd.
 * User: Aleksandr Khamutov
 * Date: 02.02.13
 * Time: 23:31
 */
object ControllerHelper {
    val viewResolver = ViewResolver()
}

fun render(viewName: String, params: Map<String, Any> = hashMapOf()): String {
    return ControllerHelper.viewResolver.resolveView(params, viewName)
}

fun render_json(params: Any): String {
    val mapper = ObjectMapper()
    return mapper.writeValueAsString(params)!!
}

