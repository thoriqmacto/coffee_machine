class Box(var height: Double, var width: Double, var length: Double) {
    // write the getVolume method here
    fun getVolume():Double{
        return this.height * this.width * this.length
    }
}