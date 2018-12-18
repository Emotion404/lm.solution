using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

using Xamarin.Forms;
using Xamarin.Forms.Xaml;

namespace NetCore
{
	[XamlCompilation(XamlCompilationOptions.Compile)]
	public partial class XamlPlusCodePage : ContentPage
	{
		public XamlPlusCodePage ()
		{
			InitializeComponent ();
		}

        private async void OnSliderValueChanged(object sender, ValueChangedEventArgs e)
        {
            valueLabel.Text = e.NewValue.ToString("F3");
        }

        private async void OnButtonClicked(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            await DisplayAlert("Clicked!", "The button labeled '" + btn.Text + "' has been clicked", "OK");
        }
    }
}