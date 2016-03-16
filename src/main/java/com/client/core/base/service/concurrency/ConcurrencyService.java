package com.client.core.base.service.concurrency;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * Service to handle calling threads asynchronously as well as synchronously.  Provided methods to call
 * a single thread asynchronously or a collection of threads either asynchronously or synchonously.
 * Supports both {@link java.lang.Runnable} and {@link java.util.concurrent.Callable}
 */
public interface ConcurrencyService {

    /**
     * Handles the passed in taskList concurrently. There is not guarantee this method will execute before subsequent client code.
     * This method is appropriate when client code is not depending on the result of the passed in {@link java.util.concurrent.Callable}.
     *
     * @param <C> type of Callable being called
     * @param <T> result of Callable being passed
     * @param task the task to run
     */
    public <T, C extends Callable<T>> void spinOneThreadAndDoNotWaitForResult(C task);

    /**
     * Handles the passed in taskList concurrently, and returns the result.
     *
     * @param <C> type of Callable being called
     * @param <T> result of Callable being passed
     * @param taskList list of tasks to run
     * @return result of running taskList
     */
    public <T, C extends Callable<T>> List<T> spinThreadsAndWaitForResult(List<C> taskList);

    /**
     * Handles the passed in taskList concurrently. There is not guarantee this method will execute before subsequent client code.
     * This method is appropriate when client code is not depending on the result of the passed in {@link java.util.List}<Callable<T>> to function.
     *
     * @param <C> type of Callable being called
     * @param <T> result of Callable being passed
     * @param taskList list of tasks to run
     */
    public <T, C extends Callable<T>> void spinThreadsAndDoNotWaitForResult(List<C> taskList);

    /**
     * Handles the passed in {@link java.lang.Runnable} concurrently. There is no guarantee this method will execute before subsequent client code.
     * This method is appropriate when client code is not depending on the passed in {@link java.lang.Runnable} being completed.
     *
     * @param <R> type of Runnable being called
     * @param task the task to run
     */
    public <R extends Runnable> void spinOneThreadAndDoNotWaitForCompletion(R task);

    /**
     * Handles the passed in {@link java.util.List}<{@link java.lang.Runnable}> concurrently. There is no guarantee this method will execute before
     * subsequent client code.  This method is appropriate when client code is depending on the passed in {@link java.lang.Runnable}s being completed.
     *
     * @param <R> type of Runnable being called
     * @param taskList the list of tasks to run
     */
    public <R extends Runnable> void spinThreadsAndWaitForCompletion(List<R> taskList);

    /**
     * Handles the passed in {@link java.util.List}<{@link java.lang.Runnable}> concurrently. There is no guarantee this method will execute before
     * subsequent client code.  This method is appropriate when client code is not depending on the passed in {@link java.lang.Runnable}s being completed.
     *
     * @param <R> type of Runnable being called
     * @param taskList the list of tasks to run
     */
    public <R extends Runnable> void spinThreadsAndDoNotWaitForCompletion(List<R> taskList);

}
