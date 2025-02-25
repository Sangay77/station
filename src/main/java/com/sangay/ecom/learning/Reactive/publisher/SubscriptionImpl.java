//package com.sangay.ecom.learning.Reactive.publisher;
//
//import com.sangay.ecom.learning.Reactive.subscriber.SubscriberImpl;
//import org.reactivestreams.Subscriber;
//import org.reactivestreams.Subscription;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//
//public class SubscriptionImpl implements Subscription {
//
//    private final Subscriber<?super String> subscriber;
//    private boolean isCancelled;
//
//    private static final Logger logger= LoggerFactory.getLogger(SubscriptionImpl.class);
//    public final Faker faker;
//
//    public SubscriptionImpl(Subscriber<?super String> subscriber) {
//
//        this.subscriber=subscriber;
//    }
//
//    @Override
//    public void request(long requested) {
//
//        if (this.isCancelled){
//            return;
//        }
//        logger.info("subscriber has requested {} items", requested);
//        for (int i=0;i<requested;i++){
//            this.subscriber.onNext();
//
//        }
//
//    }
//
//    @Override
//    public void cancel() {
//
//        logger.info("subscriber has cancelled ");
//        this.isCancelled=true;
//    }
//}
