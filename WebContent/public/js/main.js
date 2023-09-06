// Lấy các phần tử từ DOM
const decreaseBtn = document.querySelector('.btn-decrease');
const increaseBtn = document.querySelector('.btn-increase');
const inputValue = document.querySelector('.input-value');

// Định nghĩa hàm tăng giá trị
function increaseValue() {
    const currentValue = parseInt(inputValue.value);
    inputValue.value = currentValue + 1;
}

// Định nghĩa hàm giảm giá trị
function decreaseValue() {
    const currentValue = parseInt(inputValue.value);
    inputValue.value = currentValue - 1;
}

// Gán sự kiện cho nút tăng và giảm
if(decreaseBtn != null && increaseBtn != null){
	increaseBtn.addEventListener('click', increaseValue);
	decreaseBtn.addEventListener('click', decreaseValue);
}



const menuBtn = document.querySelector('.menu-icon');
const navbar = document.querySelector('.navbar');

if(menuBtn){
	menuBtn.onclick = () => {
	    navbar.classList.toggle('show')
	}
}



// Lặp qua tất cả các sản phẩm và thêm sự kiện cho nút tăng và giảm số lượng
    const products = document.querySelectorAll('.cart__body-container');

    if(products){
        products.forEach(product => {
            const decreaseButton = product.querySelector('.decrease');
            const increaseButton = product.querySelector('.increase');
            const quantityElement = product.querySelector('.input-value');
            const priceElement1 = product.querySelector('.salePrice');
            const priceElement = product.querySelector('.sale-price');
    
            if(quantityElement && decreaseButton && increaseButton && priceElement){
                // Xử lý sự kiện giảm số lượng
                decreaseButton.addEventListener('click', () => {
                    let currentQuantity = quantityElement.value;
                    if (currentQuantity > 1) {
                        currentQuantity--;
                        quantityElement.value = currentQuantity;
                        updatePrice();
                    }
                });
    
                // Xử lý sự kiện tăng số lượng
                increaseButton.addEventListener('click', () => {
                    let currentQuantity = quantityElement.value;
                    currentQuantity++;
                    quantityElement.value = currentQuantity;
                    updatePrice();
                });
    
                // Cập nhật giá dựa trên số lượng
                function updatePrice() {
                    const unitPrice = product.querySelector('.unit-price').value; // Lấy giá và loại bỏ ký hiệu $
                    const currentQuantity = quantityElement.value;
                    const totalPrice = unitPrice * currentQuantity;
                    priceElement1.textContent = totalPrice;
                    priceElement.value = totalPrice;
                }
            }
        });
    }
    
    function toggleAll(source) {
            var checkboxes = document.querySelectorAll('input[type="checkbox"]');
            if(checkboxes){
            	for (var i = 0; i < checkboxes.length; i++) {
	                checkboxes[i].checked = source.checked;
	            }
            }
        }