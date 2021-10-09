//interface for ADT Stack
//written by: Maya Tene 2021 
public interface StackInterface<T>
{
    /**
     * Adds new entry to the top of this stack
     * @param newEntry entry to be added
     */
    public void push(T newEntry);

    /**
     * Removes and return's this stack's topmost entry
     * @return the top entry of this stack
     * @throws EmptyStackException if this stack is empty before call
     */
    public T pop();

    /**
     * Retrieves topmost entry in this stack
     * @return topmost entry 
     * @throws EmptyStackException if this is empty before call
     */
    public T peek();

    /**
     * checks if stack is empty
     * @return True if empty, false otherwise
     */
    public boolean isEmpty();

    /**
     * removes all entries in stack
     */
    public void clear();

}//end Stack Interface