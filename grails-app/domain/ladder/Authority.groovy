package ladder



/**
 * Authority domain class.
 */
class Authority {

	static hasMany = [people: Player]

	/** description */
	String description
	/** ROLE String */
	String authority

	static constraints = {
		authority(blank: false, unique: true)
		description()
	}
}
