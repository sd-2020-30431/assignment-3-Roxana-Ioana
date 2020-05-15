package main.bussiness.mediator;

public interface Handler<Request, Response> {

    Response handle(Request q);
}
