package com.rss.util.async;

public interface AsyncCallback<T> {
    public void onResult(T result);
    public void exceptionOccured(Exception e);
    public void onCancelled();
}
