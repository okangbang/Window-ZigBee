package win.data;

import java.util.Date;

public class WindowsData {

		private int number;// ���ڱ��
		private int state;// 1����0��
		private Date time;// ʱ��
		private float temperature;// �¶�
		private float humidity;// ʪ��

		public WindowsData(int number, int state, Date time, float temperature,
				float humidity) {
			// super();
			this.number = number;
			this.state = state;
			this.time = time;
			this.temperature = temperature;
			this.humidity = humidity;
		}

		public WindowsData() {
			// super();
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int number) {
			this.number = number;
		}

		public int getState() {
			return state;
		}

		public void setState(int state) {
			this.state = state;
		}

		public Date getTime() {
			return time;
		}

		public void setTime(Date time) {
			this.time = time;
		}

		public float getTemperature() {
			return temperature;
		}

		public void setTemperature(float temperature) {
			this.temperature = temperature;
		}

		public float getHumidity() {
			return humidity;
		}

		public void setHumidity(float humidity) {
			this.humidity = humidity;
		}

		@Override
		public String toString() {
			return "Test [number=" + number + ", state=" + state + ", time=" + time
					+ ", temperature=" + temperature + ", humidity=" + humidity
					+ "]";
		}

	}


