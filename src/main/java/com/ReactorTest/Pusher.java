package com.ReactorTest;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;

public class Pusher implements Publisher {

    @Override
    public void subscribe(Subscriber subscriber) {
        subscriber.onComplete();
    }

}
