package srikanth;

interface MusicInstrument {
	void play();
}

class Guitar implements MusicInstrument {

	@Override
	public void play() {
		System.out.println("sai");

	}

	class Flute implements MusicInstrument {

		@Override
		public void play() {
			System.out.println("sri");

		}

	}

	class Sitar implements MusicInstrument {

		@Override
		public void play() {
			System.out.println("manoj");

		}

	}

}

public class InstrumentDemo {

	public static void main(String[] args) {
		MusicInstrument m = new Guitar();
		m.play();

	}

}
