import java.util.ArrayList;

class Customer {
    String name;
    String mobileNumber;
    String email;
    String city;
    int age;

    public Customer(String name, String mobileNumber, String email, String city, int age) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.city = city;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Mobile: " + mobileNumber + ", Email: " + email + ", City: " + city + ", Age: " + age;
    }
}

class CustomerStack {
    private ArrayList<Customer> stack;

    public CustomerStack() {
        stack = new ArrayList<>();
    }

    public void push(Customer customer) {
        stack.add(customer);
    }

    public Customer pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.remove(stack.size() - 1);
    }

    public Customer peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }
}
