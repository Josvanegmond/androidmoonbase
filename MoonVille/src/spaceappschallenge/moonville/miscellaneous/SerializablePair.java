package spaceappschallenge.moonville.miscellaneous;

import java.io.Serializable;

public class SerializablePair<F, S> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7967269516607095000L;
	public final F first;
	public final S second;

	public SerializablePair(F first, S second) {
		this.first = first;
		this.second = second;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof SerializablePair))
			return false;
		final SerializablePair<F, S> other;
		try {
			other = (SerializablePair<F, S>) o;
		} catch (ClassCastException e) {
			return false;
		}
		return first.equals(other.first) && second.equals(other.second);
	}

	public int hashCode() {
		int result = 17;
		result = 31 * result + first.hashCode();
		result = 31 * result + second.hashCode();
		return result;
	}

	public static <A, B> SerializablePair<A, B> create(A a, B b) {
		return new SerializablePair<A, B>(a, b);
	}
}
