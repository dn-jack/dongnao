package hashmap;

public class DNHashMap<K, V> implements DNMap<K, V> {

	private static Integer defaultLength = 16;

	private static double defaultLoad = 0.75;

	private Entry<K, V>[] table = null;

	// size��¼�����Ԫ�ظ���
	private int size = 0;

	DNHashMap(int defaultLength, double defaultLoad) {
		this.defaultLength = defaultLength;
		this.defaultLoad = defaultLoad;
		
		table = new Entry[defaultLength];
	}

	DNHashMap() {
		this(defaultLength, defaultLoad);
	}
	
	public V put(K key, V value) {
		
		//1������key���͹�ϣ����ȡ�������е��±�
		int index = this.getIndex(key);
		
		//2����������±��жϸ�λ���Ƿ�������
		Entry<K,V> e = table[index];
		
		if(null == e) {
			table[index] = new Entry(key,value,null,index);
			size++;
		} else {
			Entry newEntry = new Entry(key,value,e,index);
			table[index] = newEntry;
		}
		
		return table[index].getValue();
	}
	
	private int getIndex(K key) {
		//����ȡ��������ȡ����
		int m = this.defaultLength - 1;
		
		return key.hashCode() % m;
	}

	public V get(K key) {
		
		//1������key���͹�ϣ����ȡ�������е��±�
		int index = this.getIndex(key);
		
		return table[index] == null ? null : table[index].getValue();
	}

	public int size() {
		return size;
	}

	class Entry<K, V> implements DNMap.Entry<K, V> {
		
		K key;
		
		V value;
		
		Entry<K,V> next;
		
		int index;
		
		Entry(K k,V v,Entry<K,V> n,int inx) {
			key = k;
			value = v;
			index = inx;
			next = n;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

	}

}
