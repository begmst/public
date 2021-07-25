package tictactoe;

class Field {
	private FieldType fieldType = FieldType.Empty;
	
	public void setType(FieldType fieldType) {
		this.fieldType = fieldType;
	}
	
	public boolean isFree() {
		return this.fieldType == FieldType.Empty;
	}
}
