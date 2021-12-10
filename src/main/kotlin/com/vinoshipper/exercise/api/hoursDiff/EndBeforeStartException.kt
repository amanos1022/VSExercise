package com.vinoshipper.exercise.api.hoursDiff

class EndBeforeStartException : Exception{
    constructor() : super("End date is before start date... That doesn't make sense!")
}