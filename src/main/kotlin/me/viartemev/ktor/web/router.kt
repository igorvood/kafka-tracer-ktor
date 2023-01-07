package me.viartemev.ktor.me.viartemev.ktor.web

import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.viartemev.ktor.me.viartemev.ktor.service.EventService
import me.viartemev.ktor.domain.Event

fun Route.events(eventService: EventService) {

    route("/events") {
        post {
            val event = call.receive<Event>()
            eventService.sendEvent(event)
            call.respond(HttpStatusCode.Accepted)
        }
    }

}