<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<form action="categoryRating" method="post">
	<div id="rating">
		<input type="radio" id="star10" name="rating" value="10" ${rate.point == 10 ? 'checked' : '' }/>
            <label class = "full" for="star10" title="Awesome - 10 stars"></label>
            
            <input type="radio" id="star9half" name="rating" value="9.5" ${rate.point == 9.5 ? 'checked' : '' }/>
            <label class="half" for="star9half" title="Pretty good - 9.5 stars"></label>
            
            <input type="radio" id="star9" name="rating" value="9" ${rate.point == 9 ? 'checked' : '' }/>
            <label class = "full" for="star9" title="Pretty good - 9 stars"></label>
            
            <input type="radio" id="star8half" name="rating" value="8.5" ${rate.point == 8.5 ? 'checked' : '' }/>
            <label class="half" for="star8half" title="Good - 8.5 stars"></label>
            
            <input type="radio" id="star8" name="rating" value="8" ${rate.point == 8 ? 'checked' : '' }/>
            <label class = "full" for="star8" title="Good - 8 stars"></label>
            
            <input type="radio" id="star7half" name="rating" value="7.5" ${rate.point == 7.5 ? 'checked' : '' }/>
            <label class="half" for="star7half" title="Normal - 7.5 stars"></label>
            
            <input type="radio" id="star7" name="rating" value="7" ${rate.point == 7 ? 'checked' : '' }/>
            <label class = "full" for="star7" title="Normal - 7 stars"></label>
            
            <input type="radio" id="star6half" name="rating" value="6.5" ${rate.point == 6.5 ? 'checked' : '' }/>
            <label class="half" for="star6half" title="Meh - 6.5 stars"></label>
            
            <input type="radio" id="star6" name="rating" value="6" ${rate.point == 6 ? 'checked' : '' }/>
            <label class = "full" for="star6" title="Meh - 6 star"></label>
            
            <input type="radio" id="star5half" name="rating" value="5.5" ${rate.point == 5.5 ? 'checked' : '' }/>
            <label class="half" for="star5half" title="Bad - 5.5 stars"></label>

            <input type="radio" id="star5" name="rating" value="5" ${rate.point == 5 ? 'checked' : '' }/>
            <label class = "full" for="star5" title="Bad - 5 stars"></label>
            
            <input type="radio" id="star4half" name="rating" value="4.5" ${rate.point == 4.5 ? 'checked' : '' }/>
            <label class="half" for="star4half" title="Kinda bad - 4.5 stars"></label>
            
            <input type="radio" id="star4" name="rating" value="4" ${rate.point == 4 ? 'checked' : '' }/>
            <label class = "full" for="star4" title="Kinda bad - 4 stars"></label>
            
            <input type="radio" id="star3half" name="rating" value="3.5" ${rate.point == 3.5 ? 'checked' : '' }/>
            <label class="half" for="star3half" title="Sucks big time - 3.5 stars"></label>
            
            <input type="radio" id="star3" name="rating" value="3" ${rate.point == 3 ? 'checked' : '' }/>
            <label class = "full" for="star3" title="Sucks big time - 3 stars"></label>
            
            <input type="radio" id="star2half" name="rating" value="2.5" ${rate.point == 2.5 ? 'checked' : '' }/>
            <label class="half" for="star2half" title="Sucks big time- 2.5 stars"></label>
            
            <input type="radio" id="star2" name="rating" value="2" ${rate.point == 2 ? 'checked' : '' }/>
            <label class = "full" for="star2" title="Sucks big time - 2 stars"></label>
            
            <input type="radio" id="star1half" name="rating" value="1.5" ${rate.point == 1.5 ? 'checked' : '' }/>
            <label class="half" for="star1half" title="Sucks big time- 1.5 stars"></label>
            
            <input type="radio" id="star1" name="rating" value="1" ${rate.point == 1 ? 'checked' : '' }/>
            <label class = "full" for="star1" title="Sucks big time - 1 star"></label>
            
            <input type="radio" id="starhalf" name="rating" value="0.5" ${rate.point == 0.5 ? 'checked' : '' }/>
            <label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
	</div>

	<button class="btn btn-lg btn-outline-warning text-white float-right"
		style="font-size: 12px" formaction="categoryRating">Rating</button>
</form>
<script>
	function calcRate(r) {
		const f = ~~r, //Tương tự Math.floor(r)
		id = 'star' + f + (r % f ? 'half' : '')
		id && (document.getElementById(id).checked = !0)

	}
</script>
<!-- 
document.getElementsByName('rating').forEach(radio =>{
if(radio.checked){ console.log(radio.value) } }); -->
