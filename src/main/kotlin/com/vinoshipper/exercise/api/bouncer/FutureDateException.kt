package com.vinoshipper.exercise.api.bouncer

class FutureDateException : Exception {
    constructor() : super("No future people allowed")
}