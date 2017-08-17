// This is a simplified version of the java.util.Set interface.
// The assumptions about Set we can make are:
// 1.) A Set contains 0 or 1 of any element (no duplicates)
// 2.) A Set cannot contain null.
// 3.) A Set has no particular order.
public interface Set<E> {
    // This method should add the element to the set and return true.
    // If the element is already in the set, return false.
    // If the element is null, return false.
    boolean add(E element);

    // This method should remove the element from the set and return true.
    // Return false if the element is null.
    // Return false if the element isn't in the set.
    boolean remove(E element);

    // Removes everything from the Set.
    // This may be more efficient than calling remove() many times.
    void clear();

    // Return true if the element is in the Set, otherwise false.
    // Return false if the element is null.
    boolean contains(E element);

    // Return the number of elements in the set.
    // A set with no elements has size 0.
    int size();

    // Return true if the size is 0.
    // This may be more efficient than calling size().
    boolean isEmpty();

    // You also need a toString() but we are not listing it here.
}