# Requirements
* The elevator system should consist of multiple elevators serving multiple floors.
* Each elevator should have a capacity limit and should not exceed it.
* Users should be able to request an elevator from any floor and select a destination floor.
* The elevator system should efficiently handle user requests and optimize the movement of elevators to minimize waiting time.
* The system should prioritize requests based on the direction of travel and the proximity of the elevators to the requested floor.
* The elevators should be able to handle multiple requests concurrently and process them in an optimal order.
* The system should ensure thread safety and prevent race conditions when multiple threads interact with the elevators.

- - -

## Requirement clarification:
- how many lift we should consider?
- in case of multiple lifts  lift dispatch algo : odd/even,fixed floor

## Objects:
Building,
Floor,
External button
Elevatorcar,
Display
Internal button
Direction,
status,

### Key Concepts used
* wait():

This is a method from the Object class. When wait() is called, the thread releases the lock it holds on the object and enters a waiting state.
It will remain in the waiting state until another thread calls notify() or notifyAll() on the same object, signaling that a change has occurred (e.g., a new request is added).
Using wait() allows the thread to pause and release the lock so that other threads can access the object (e.g., to add new requests).

* new Thread(elevator::run).start()

creates a new thread that executes the run method of the elevator object