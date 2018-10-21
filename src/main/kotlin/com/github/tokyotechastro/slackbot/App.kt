package com.github.tokyotechastro.slackbot

import com.github.tokyotechastro.slackbot.view.MainView
import com.ullink.slack.simpleslackapi.SlackSession
import com.ullink.slack.simpleslackapi.impl.SlackSessionFactory
import tornadofx.App

/**
 * Created on 2018/10/22.
 */
const val token = ""
val session: SlackSession by lazy { SlackSessionFactory.createWebSocketSlackSession(token) }

fun go (doing: SlackSession.() -> Unit) {
    session.connect()
    try {
        session.doing()
    } finally {
        session.disconnect()
    }
}

class App:App(MainView::class)