package main.mediator;

public interface Handler<Request, Response> {

    Response handle(Request q);
}
